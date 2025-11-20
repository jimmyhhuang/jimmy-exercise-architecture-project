# 架构项目前端

基于Vue3 + Element Plus + Axios的前端项目，用于测试后端API接口。

## 功能特性

- ✅ Vue 3 组合式API
- ✅ Element Plus UI组件库
- ✅ Axios HTTP请求库
- ✅ API路径输入框
- ✅ JSON参数输入框
- ✅ GET/POST请求按钮
- ✅ 响应结果展示

## 项目结构

```
architecture-front-project/
├── src/
│   ├── api/
│   │   └── request.js      # Axios配置和API请求函数
│   ├── App.vue             # 主组件
│   └── main.js             # 应用入口
├── index.html              # HTML模板
├── package.json            # 项目配置
├── vite.config.js          # Vite配置
└── README.md               # 项目说明
```

## 安装依赖

```bash
cd architecture-front-project
npm install
```

## 运行项目

```bash
npm run dev
```

项目将在 http://localhost:3000 启动

## 使用说明

1. 在"API路径"输入框中输入后端API路径（如：`/user/add`）
2. 在"请求参数"输入框中输入JSON格式的参数（如：`{"name": "test", "age": 25}`）
3. 点击"GET请求"或"POST请求"按钮发送请求
4. 查看下方的响应结果区域获取返回数据

## 后端API配置

默认后端地址为：`http://localhost:5173/api`

如需修改后端地址，请编辑 `src/api/request.js` 文件中的 `baseURL` 配置。

## 构建项目

```bash
npm run build
```

## 预览构建结果

```bash
npm run preview
```