import axios from 'axios'

// 创建axios实例
const request = axios.create({
  baseURL: 'http://localhost:5173/api',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
})

// 请求拦截器
request.interceptors.request.use(
  (config) => {
    console.log('发送请求:', config.method, config.url)
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

// 响应拦截器
request.interceptors.response.use(
  (response) => {
    return response.data
  },
  (error) => {
    console.error('请求错误:', error)
    return Promise.reject(error)
  }
)

// GET请求函数
export const getRequest = (url, params = {}) => {
  return request({
    method: 'GET',
    url: url,
    params: params
  })
}

// POST请求函数
export const postRequest = (url, data = {}) => {
  return request({
    method: 'POST',
    url: url,
    data: data
  })
}

export default request