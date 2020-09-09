<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['datahub:template:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['datahub:template:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['datahub:template:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['datahub:template:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="templateList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="所属项目Id" align="center" prop="id" />
      <el-table-column label="执行器主键ID" align="center" prop="jobGroup" />
      <el-table-column label="任务执行CRON" align="center" prop="jobCron" />
      <el-table-column label="任务执行CRON" align="center" prop="jobDesc" />
      <el-table-column label="任务执行CRON" align="center" prop="addTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.addTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改用户" align="center" prop="userId" />
      <el-table-column label="报警邮件" align="center" prop="alarmEmail" />
      <el-table-column label="执行器路由策略" align="center" prop="executorRouteStrategy" />
      <el-table-column label="执行器任务handler" align="center" prop="executorHandler" />
      <el-table-column label="执行器参数" align="center" prop="executorParam" />
      <el-table-column label="阻塞处理策略" align="center" prop="executorBlockStrategy" />
      <el-table-column label="任务执行超时时间，单位秒" align="center" prop="executorTimeout" />
      <el-table-column label="失败重试次数" align="center" prop="executorFailRetryCount" />
      <el-table-column label="GLUE类型" align="center" prop="glueType" />
      <el-table-column label="GLUE源代码" align="center" prop="glueSource" />
      <el-table-column label="GLUE备注" align="center" prop="glueRemark" />
      <el-table-column label="GLUE更新时间" align="center" prop="glueUpdatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.glueUpdatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="子任务ID，多个逗号分隔" align="center" prop="childJobid" />
      <el-table-column label="上次调度时间" align="center" prop="triggerLastTime" />
      <el-table-column label="下次调度时间" align="center" prop="triggerNextTime" />
      <el-table-column label="datax运行脚本" align="center" prop="jobJson" />
      <el-table-column label="jvm参数" align="center" prop="jvmParam" />
      <el-table-column label="所属项目Id" align="center" prop="projectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['datahub:template:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['datahub:template:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改模板对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="执行器主键ID" prop="jobGroup">
          <el-input v-model="form.jobGroup" placeholder="请输入执行器主键ID" />
        </el-form-item>
        <el-form-item label="任务执行CRON" prop="jobCron">
          <el-input v-model="form.jobCron" placeholder="请输入任务执行CRON" />
        </el-form-item>
        <el-form-item label="任务执行CRON" prop="jobDesc">
          <el-input v-model="form.jobDesc" placeholder="请输入任务执行CRON" />
        </el-form-item>
        <el-form-item label="任务执行CRON" prop="addTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.addTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择任务执行CRON">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改用户" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入修改用户" />
        </el-form-item>
        <el-form-item label="报警邮件" prop="alarmEmail">
          <el-input v-model="form.alarmEmail" placeholder="请输入报警邮件" />
        </el-form-item>
        <el-form-item label="执行器路由策略" prop="executorRouteStrategy">
          <el-input v-model="form.executorRouteStrategy" placeholder="请输入执行器路由策略" />
        </el-form-item>
        <el-form-item label="执行器任务handler" prop="executorHandler">
          <el-input v-model="form.executorHandler" placeholder="请输入执行器任务handler" />
        </el-form-item>
        <el-form-item label="执行器参数" prop="executorParam">
          <el-input v-model="form.executorParam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="阻塞处理策略" prop="executorBlockStrategy">
          <el-input v-model="form.executorBlockStrategy" placeholder="请输入阻塞处理策略" />
        </el-form-item>
        <el-form-item label="任务执行超时时间，单位秒" prop="executorTimeout">
          <el-input v-model="form.executorTimeout" placeholder="请输入任务执行超时时间，单位秒" />
        </el-form-item>
        <el-form-item label="失败重试次数" prop="executorFailRetryCount">
          <el-input v-model="form.executorFailRetryCount" placeholder="请输入失败重试次数" />
        </el-form-item>
        <el-form-item label="GLUE类型" prop="glueType">
          <el-select v-model="form.glueType" placeholder="请选择GLUE类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="GLUE源代码" prop="glueSource">
          <el-input v-model="form.glueSource" placeholder="请输入GLUE源代码" />
        </el-form-item>
        <el-form-item label="GLUE备注" prop="glueRemark">
          <el-input v-model="form.glueRemark" placeholder="请输入GLUE备注" />
        </el-form-item>
        <el-form-item label="GLUE更新时间" prop="glueUpdatetime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.glueUpdatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择GLUE更新时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="子任务ID，多个逗号分隔" prop="childJobid">
          <el-input v-model="form.childJobid" placeholder="请输入子任务ID，多个逗号分隔" />
        </el-form-item>
        <el-form-item label="上次调度时间" prop="triggerLastTime">
          <el-input v-model="form.triggerLastTime" placeholder="请输入上次调度时间" />
        </el-form-item>
        <el-form-item label="下次调度时间" prop="triggerNextTime">
          <el-input v-model="form.triggerNextTime" placeholder="请输入下次调度时间" />
        </el-form-item>
        <el-form-item label="datax运行脚本" prop="jobJson">
          <el-input v-model="form.jobJson" placeholder="请输入datax运行脚本" />
        </el-form-item>
        <el-form-item label="jvm参数" prop="jvmParam">
          <el-input v-model="form.jvmParam" placeholder="请输入jvm参数" />
        </el-form-item>
        <el-form-item label="所属项目Id" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入所属项目Id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTemplate, getTemplate, delTemplate, addTemplate, updateTemplate, exportTemplate } from "@/api/datahub/template";

export default {
  name: "Template",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 模板表格数据
      templateList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        jobGroup: [
          { required: true, message: "执行器主键ID不能为空", trigger: "blur" }
        ],
        jobCron: [
          { required: true, message: "任务执行CRON不能为空", trigger: "blur" }
        ],
        jobDesc: [
          { required: true, message: "任务执行CRON不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "修改用户不能为空", trigger: "blur" }
        ],
        executorTimeout: [
          { required: true, message: "任务执行超时时间，单位秒不能为空", trigger: "blur" }
        ],
        executorFailRetryCount: [
          { required: true, message: "失败重试次数不能为空", trigger: "blur" }
        ],
        glueType: [
          { required: true, message: "GLUE类型不能为空", trigger: "change" }
        ],
        triggerLastTime: [
          { required: true, message: "上次调度时间不能为空", trigger: "blur" }
        ],
        triggerNextTime: [
          { required: true, message: "下次调度时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询模板列表 */
    getList() {
      this.loading = true;
      listTemplate(this.queryParams).then(response => {
        this.templateList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        jobGroup: null,
        jobCron: null,
        jobDesc: null,
        addTime: null,
        updateTime: null,
        userId: null,
        alarmEmail: null,
        executorRouteStrategy: null,
        executorHandler: null,
        executorParam: null,
        executorBlockStrategy: null,
        executorTimeout: null,
        executorFailRetryCount: null,
        glueType: null,
        glueSource: null,
        glueRemark: null,
        glueUpdatetime: null,
        childJobid: null,
        triggerLastTime: null,
        triggerNextTime: null,
        jobJson: null,
        jvmParam: null,
        projectId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加模板";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTemplate(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改模板";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTemplate(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addTemplate(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除模板编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTemplate(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有模板数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTemplate(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
