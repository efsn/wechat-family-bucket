rootProject.name = "wechat-family-bucket"
files("wechat-mobile-app", "wechat-official-account", "wechat-websit").forEach { dir ->
    dir.listFiles().forEach {
        if (it.isDirectory) {
            include(it.name)
            project(":${it.name}").projectDir = it
        }
    }
}