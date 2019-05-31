module.exports = {
    // Change build paths to make them Maven compatible
    // see https://cli.vuejs.org/config/
    outputDir: 'target/dist',
    assetsDir: 'static',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            },
            '/login': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            },
            '/logout': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            },
            '/img': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    }
  }