<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编码" prop="readerDatasource">
        <el-input
          v-model="queryParams.readerDatasource"
          placeholder="请输入编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编码" prop="readerDatabase">
        <el-input
          v-model="queryParams.readerDatabase"
          placeholder="请输入编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编码" prop="readerQuerySql">
        <el-input
          v-model="queryParams.readerQuerySql"
          placeholder="请输入编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="切分主键" prop="readerSplitpk">
        <el-input
          v-model="queryParams.readerSplitpk"
          placeholder="请输入切分主键"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入数据源" prop="writerDatasource">
        <el-input
          v-model="queryParams.writerDatasource"
          placeholder="请输入写入数据源"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入数据库" prop="writerDatabase">
        <el-input
          v-model="queryParams.writerDatabase"
          placeholder="请输入写入数据库"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入表名" prop="writerTable">
        <el-input
          v-model="queryParams.writerTable"
          placeholder="请输入写入表名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入列" prop="writerColumn">
        <el-input
          v-model="queryParams.writerColumn"
          placeholder="请输入写入列"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入模式" prop="writeMode">
        <el-input
          v-model="queryParams.writeMode"
          placeholder="请输入写入模式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="写入模式" prop="batchsize">
        <el-input
          v-model="queryParams.batchsize"
          placeholder="请输入写入模式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="变量列表" prop="vars">
        <el-input
          v-model="queryParams.vars"
          placeholder="请输入变量列表"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编码" prop="encoding">
        <el-input
          v-model="queryParams.encoding"
          placeholder="请输入编码"
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
          v-hasPermi="['datahub:mapping:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['datahub:mapping:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['datahub:mapping:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['datahub:mapping:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mappingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编码" align="center" prop="id" />
      <el-table-column label="编码" align="center" prop="readerDatasource" />
      <el-table-column label="编码" align="center" prop="readerDatabase" />
      <el-table-column label="编码" align="center" prop="readerQuerySql" />
      <el-table-column label="表" align="center" prop="readerTable" />
      <el-table-column label="列" align="center" prop="readerColumn" />
      <el-table-column label="查询条件" align="center" prop="readerWhere" />
      <el-table-column label="切分主键" align="center" prop="readerSplitpk" />
      <el-table-column label="写入数据源" align="center" prop="writerDatasource" />
      <el-table-column label="写入数据库" align="center" prop="writerDatabase" />
      <el-table-column label="写入表名" align="center" prop="writerTable" />
      <el-table-column label="写入列" align="center" prop="writerColumn" />
      <el-table-column label="预处理" align="center" prop="writerPreSql" />
      <el-table-column label="后处理" align="center" prop="writerPostSql" />
      <el-table-column label="session配置" align="center" prop="writerSession" />
      <el-table-column label="写入模式" align="center" prop="writeMode" />
      <el-table-column label="写入模式" align="center" prop="batchsize" />
      <el-table-column label="变量列表" align="center" prop="vars" />
      <el-table-column label="编码" align="center" prop="encoding" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['datahub:mapping:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['datahub:mapping:remove']"
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

    <!-- 添加或修改同步映射对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编码" prop="readerDatasource">
          <el-input v-model="form.readerDatasource" placeholder="请输入编码" />
        </el-form-item>
        <el-form-item label="编码" prop="readerDatabase">
          <el-input v-model="form.readerDatabase" placeholder="请输入编码" />
        </el-form-item>
        <el-form-item label="编码" prop="readerQuerySql">
          <el-input v-model="form.readerQuerySql" placeholder="请输入编码" />
        </el-form-item>
        <el-form-item label="表" prop="readerTable">
          <el-input v-model="form.readerTable" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="列" prop="readerColumn">
          <el-input v-model="form.readerColumn" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="查询条件" prop="readerWhere">
          <el-input v-model="form.readerWhere" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="切分主键" prop="readerSplitpk">
          <el-input v-model="form.readerSplitpk" placeholder="请输入切分主键" />
        </el-form-item>
        <el-form-item label="写入数据源" prop="writerDatasource">
          <el-input v-model="form.writerDatasource" placeholder="请输入写入数据源" />
        </el-form-item>
        <el-form-item label="写入数据库" prop="writerDatabase">
          <el-input v-model="form.writerDatabase" placeholder="请输入写入数据库" />
        </el-form-item>
        <el-form-item label="写入表名" prop="writerTable">
          <el-input v-model="form.writerTable" placeholder="请输入写入表名" />
        </el-form-item>
        <el-form-item label="写入列" prop="writerColumn">
          <el-input v-model="form.writerColumn" placeholder="请输入写入列" />
        </el-form-item>
        <el-form-item label="预处理" prop="writerPreSql">
          <el-input v-model="form.writerPreSql" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="后处理" prop="writerPostSql">
          <el-input v-model="form.writerPostSql" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="session配置" prop="writerSession">
          <el-input v-model="form.writerSession" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="写入模式" prop="writeMode">
          <el-input v-model="form.writeMode" placeholder="请输入写入模式" />
        </el-form-item>
        <el-form-item label="写入模式" prop="batchsize">
          <el-input v-model="form.batchsize" placeholder="请输入写入模式" />
        </el-form-item>
        <el-form-item label="变量列表" prop="vars">
          <el-input v-model="form.vars" placeholder="请输入变量列表" />
        </el-form-item>
        <el-form-item label="编码" prop="encoding">
          <el-input v-model="form.encoding" placeholder="请输入编码" />
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
import { listMapping, getMapping, delMapping, addMapping, updateMapping, exportMapping } from "@/api/datahub/mapping";

export default {
  name: "Mapping",
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
      // 同步映射表格数据
      mappingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        readerDatasource: null,
        readerDatabase: null,
        readerQuerySql: null,
        readerTable: null,
        readerColumn: null,
        readerWhere: null,
        readerSplitpk: null,
        writerDatasource: null,
        writerDatabase: null,
        writerTable: null,
        writerColumn: null,
        writerPreSql: null,
        writerPostSql: null,
        writerSession: null,
        writeMode: null,
        batchsize: null,
        vars: null,
        encoding: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询同步映射列表 */
    getList() {
      this.loading = true;
      listMapping(this.queryParams).then(response => {
        this.mappingList = response.rows;
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
        readerDatasource: null,
        readerDatabase: null,
        readerQuerySql: null,
        readerTable: null,
        readerColumn: null,
        readerWhere: null,
        readerSplitpk: null,
        writerDatasource: null,
        writerDatabase: null,
        writerTable: null,
        writerColumn: null,
        writerPreSql: null,
        writerPostSql: null,
        writerSession: null,
        writeMode: null,
        batchsize: null,
        vars: null,
        encoding: null
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
      this.title = "添加同步映射";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMapping(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改同步映射";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMapping(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addMapping(this.form).then(response => {
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
      this.$confirm('是否确认删除同步映射编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMapping(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有同步映射数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportMapping(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
