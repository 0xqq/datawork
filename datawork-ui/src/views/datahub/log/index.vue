<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="执行器主键ID" prop="jobGroup">
        <el-input
          v-model="queryParams.jobGroup"
          placeholder="请输入执行器主键ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务，主键ID" prop="jobId">
        <el-input
          v-model="queryParams.jobId"
          placeholder="请输入任务，主键ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务，主键ID" prop="jobDesc">
        <el-input
          v-model="queryParams.jobDesc"
          placeholder="请输入任务，主键ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="执行器地址，本次执行的地址" prop="executorAddress">
        <el-input
          v-model="queryParams.executorAddress"
          placeholder="请输入执行器地址，本次执行的地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="执行器任务handler" prop="executorHandler">
        <el-input
          v-model="queryParams.executorHandler"
          placeholder="请输入执行器任务handler"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="执行器任务分片参数，格式如 1/2" prop="executorShardingParam">
        <el-input
          v-model="queryParams.executorShardingParam"
          placeholder="请输入执行器任务分片参数，格式如 1/2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="失败重试次数" prop="executorFailRetryCount">
        <el-input
          v-model="queryParams.executorFailRetryCount"
          placeholder="请输入失败重试次数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调度-时间" prop="triggerTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.triggerTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择调度-时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="调度-结果" prop="triggerCode">
        <el-input
          v-model="queryParams.triggerCode"
          placeholder="请输入调度-结果"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调度-日志" prop="triggerMsg">
        <el-input
          v-model="queryParams.triggerMsg"
          placeholder="请输入调度-日志"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="执行-时间" prop="handleTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.handleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择执行-时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="执行-状态" prop="handleCode">
        <el-input
          v-model="queryParams.handleCode"
          placeholder="请输入执行-状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="执行-日志" prop="handleMsg">
        <el-input
          v-model="queryParams.handleMsg"
          placeholder="请输入执行-日志"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败" prop="alarmStatus">
        <el-select v-model="queryParams.alarmStatus" placeholder="请选择告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="datax进程Id" prop="processId">
        <el-input
          v-model="queryParams.processId"
          placeholder="请输入datax进程Id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="增量表max id" prop="maxId">
        <el-input
          v-model="queryParams.maxId"
          placeholder="请输入增量表max id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['datahub:log:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['datahub:log:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['datahub:log:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['datahub:log:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="logList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="增量表max id" align="center" prop="id" />
      <el-table-column label="执行器主键ID" align="center" prop="jobGroup" />
      <el-table-column label="任务，主键ID" align="center" prop="jobId" />
      <el-table-column label="任务，主键ID" align="center" prop="jobDesc" />
      <el-table-column label="执行器地址，本次执行的地址" align="center" prop="executorAddress" />
      <el-table-column label="执行器任务handler" align="center" prop="executorHandler" />
      <el-table-column label="执行器任务参数" align="center" prop="executorParam" />
      <el-table-column label="执行器任务分片参数，格式如 1/2" align="center" prop="executorShardingParam" />
      <el-table-column label="失败重试次数" align="center" prop="executorFailRetryCount" />
      <el-table-column label="调度-时间" align="center" prop="triggerTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.triggerTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="调度-结果" align="center" prop="triggerCode" />
      <el-table-column label="调度-日志" align="center" prop="triggerMsg" />
      <el-table-column label="执行-时间" align="center" prop="handleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.handleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="执行-状态" align="center" prop="handleCode" />
      <el-table-column label="执行-日志" align="center" prop="handleMsg" />
      <el-table-column label="告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败" align="center" prop="alarmStatus" />
      <el-table-column label="datax进程Id" align="center" prop="processId" />
      <el-table-column label="增量表max id" align="center" prop="maxId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['datahub:log:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['datahub:log:remove']"
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

    <!-- 添加或修改日志对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="执行器主键ID" prop="jobGroup">
          <el-input v-model="form.jobGroup" placeholder="请输入执行器主键ID" />
        </el-form-item>
        <el-form-item label="任务，主键ID" prop="jobId">
          <el-input v-model="form.jobId" placeholder="请输入任务，主键ID" />
        </el-form-item>
        <el-form-item label="任务，主键ID" prop="jobDesc">
          <el-input v-model="form.jobDesc" placeholder="请输入任务，主键ID" />
        </el-form-item>
        <el-form-item label="执行器地址，本次执行的地址" prop="executorAddress">
          <el-input v-model="form.executorAddress" placeholder="请输入执行器地址，本次执行的地址" />
        </el-form-item>
        <el-form-item label="执行器任务handler" prop="executorHandler">
          <el-input v-model="form.executorHandler" placeholder="请输入执行器任务handler" />
        </el-form-item>
        <el-form-item label="执行器任务参数" prop="executorParam">
          <el-input v-model="form.executorParam" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="执行器任务分片参数，格式如 1/2" prop="executorShardingParam">
          <el-input v-model="form.executorShardingParam" placeholder="请输入执行器任务分片参数，格式如 1/2" />
        </el-form-item>
        <el-form-item label="失败重试次数" prop="executorFailRetryCount">
          <el-input v-model="form.executorFailRetryCount" placeholder="请输入失败重试次数" />
        </el-form-item>
        <el-form-item label="调度-时间" prop="triggerTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.triggerTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择调度-时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="调度-结果" prop="triggerCode">
          <el-input v-model="form.triggerCode" placeholder="请输入调度-结果" />
        </el-form-item>
        <el-form-item label="调度-日志" prop="triggerMsg">
          <el-input v-model="form.triggerMsg" placeholder="请输入调度-日志" />
        </el-form-item>
        <el-form-item label="执行-时间" prop="handleTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.handleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择执行-时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="执行-状态" prop="handleCode">
          <el-input v-model="form.handleCode" placeholder="请输入执行-状态" />
        </el-form-item>
        <el-form-item label="执行-日志" prop="handleMsg">
          <el-input v-model="form.handleMsg" placeholder="请输入执行-日志" />
        </el-form-item>
        <el-form-item label="告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败">
          <el-radio-group v-model="form.alarmStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="datax进程Id" prop="processId">
          <el-input v-model="form.processId" placeholder="请输入datax进程Id" />
        </el-form-item>
        <el-form-item label="增量表max id" prop="maxId">
          <el-input v-model="form.maxId" placeholder="请输入增量表max id" />
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
import { listLog, getLog, delLog, addLog, updateLog, exportLog } from "@/api/datahub/log";

export default {
  name: "Log",
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
      // 日志表格数据
      logList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        jobGroup: null,
        jobId: null,
        jobDesc: null,
        executorAddress: null,
        executorHandler: null,
        executorParam: null,
        executorShardingParam: null,
        executorFailRetryCount: null,
        triggerTime: null,
        triggerCode: null,
        triggerMsg: null,
        handleTime: null,
        handleCode: null,
        handleMsg: null,
        alarmStatus: null,
        processId: null,
        maxId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        jobGroup: [
          { required: true, message: "执行器主键ID不能为空", trigger: "blur" }
        ],
        jobId: [
          { required: true, message: "任务，主键ID不能为空", trigger: "blur" }
        ],
        triggerCode: [
          { required: true, message: "调度-结果不能为空", trigger: "blur" }
        ],
        handleCode: [
          { required: true, message: "执行-状态不能为空", trigger: "blur" }
        ],
        alarmStatus: [
          { required: true, message: "告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询日志列表 */
    getList() {
      this.loading = true;
      listLog(this.queryParams).then(response => {
        this.logList = response.rows;
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
        jobId: null,
        jobDesc: null,
        executorAddress: null,
        executorHandler: null,
        executorParam: null,
        executorShardingParam: null,
        executorFailRetryCount: null,
        triggerTime: null,
        triggerCode: null,
        triggerMsg: null,
        handleTime: null,
        handleCode: null,
        handleMsg: null,
        alarmStatus: 0,
        processId: null,
        maxId: null
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
      this.title = "添加日志";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLog(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改日志";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLog(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addLog(this.form).then(response => {
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
      this.$confirm('是否确认删除日志编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delLog(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有日志数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportLog(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
