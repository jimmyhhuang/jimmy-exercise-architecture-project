<template>
  <div class="app-container">
    <el-card class="api-card" header="API测试工具">
      <el-form :model="form" label-width="120px">
        <el-form-item label="API路径">
          <el-input 
            v-model="form.apiPath" 
            placeholder="请输入API路径，如：/user/add"
            clearable
          />
        </el-form-item>
        
        <el-form-item label="请求参数">
          <el-input
            v-model="form.requestParams"
            type="textarea"
            :rows="5"
            placeholder='请输入JSON格式的请求参数，如：{"name": "test", "age": 25}'
            clearable
          />
        </el-form-item>
        
        <el-form-item>
          <el-button type="primary" @click="handleGetRequest" :loading="getLoading">
            GET请求
          </el-button>
          <el-button type="success" @click="handlePostRequest" :loading="postLoading">
            POST请求
          </el-button>
        </el-form-item>
      </el-form>
      
      <el-divider />
      
      <div class="response-section">
        <h3>响应结果：</h3>
        <el-alert
          v-if="responseError"
          :title="responseError"
          type="error"
          :closable="false"
          show-icon
        />
        <el-card v-else-if="responseData" class="response-card">
          <pre>{{ JSON.stringify(responseData, null, 2) }}</pre>
        </el-card>
        <el-empty v-else description="暂无响应数据" :image-size="100" />
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { getRequest, postRequest } from './api/request.js'

// 表单数据
const form = ref({
  apiPath: '',
  requestParams: ''
})

// 响应数据
const responseData = ref(null)
const responseError = ref('')

// 加载状态
const getLoading = ref(false)
const postLoading = ref(false)

// 解析JSON参数
const parseJsonParams = (jsonString) => {
  if (!jsonString.trim()) return {}
  
  try {
    return JSON.parse(jsonString)
  } catch (error) {
    ElMessage.error('JSON格式错误，请检查参数格式')
    throw error
  }
}

// GET请求处理
const handleGetRequest = async () => {
  if (!form.value.apiPath) {
    ElMessage.warning('请输入API路径')
    return
  }
  
  getLoading.value = true
  responseError.value = ''
  responseData.value = null
  
  try {
    const params = parseJsonParams(form.value.requestParams)
    const result = await getRequest(form.value.apiPath, params)
    responseData.value = result
    ElMessage.success('GET请求成功')
  } catch (error) {
    responseError.value = error.message || '请求失败'
    ElMessage.error('GET请求失败')
  } finally {
    getLoading.value = false
  }
}

// POST请求处理
const handlePostRequest = async () => {
  if (!form.value.apiPath) {
    ElMessage.warning('请输入API路径')
    return
  }
  
  postLoading.value = true
  responseError.value = ''
  responseData.value = null
  
  try {
    const data = parseJsonParams(form.value.requestParams)
    const result = await postRequest(form.value.apiPath, data)
    responseData.value = result
    ElMessage.success('POST请求成功')
  } catch (error) {
    responseError.value = error.message || '请求失败'
    ElMessage.error('POST请求失败')
  } finally {
    postLoading.value = false
  }
}
</script>

<style scoped>
.app-container {
  padding: 20px;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.api-card {
  max-width: 800px;
  margin: 0 auto;
}

.response-section {
  margin-top: 20px;
}

.response-card {
  margin-top: 10px;
}

.response-card pre {
  white-space: pre-wrap;
  word-wrap: break-word;
  font-family: 'Courier New', monospace;
  font-size: 14px;
}

.el-button {
  margin-right: 10px;
}
</style>