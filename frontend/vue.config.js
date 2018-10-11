module.exports = {
  baseUrl: '/app/',
  devServer: {
    proxy: process.env.VUE_APP_PROXY
  }
}
