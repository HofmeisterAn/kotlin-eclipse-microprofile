module.exports = {
  publicPath: '/app/',
  devServer: {
    port: 8081,
    proxy: process.env.VUE_APP_PROXY
  }
}
