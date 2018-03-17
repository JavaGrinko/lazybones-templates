import static org.apache.commons.io.FileUtils.moveFileToDirectory

Map<String,String> props = [:]

props.pluginName = ask('Введите название плагина без пробелов в CamelCase [TestPlugin]): ', 'TestPlugin')
props.pluginNameLowercase = props.pluginName.toLowerCase()
props.pluginVersion = ask('Введите версию плагина [1.0.0]: ', '1.0.0')
props.pluginAuthor = ask('Введите автора плагина в формате Имя <Почта> [User <user@test.com>]: ', 'User <user@test.com>')
props.pluginDescription = ask('Введите описание плагина [Test plugin]: ', 'Test plugin')
props.pluginWebsite = ask('Введите сайт плагина [google.com]: ', 'google.com')
props.pluginGreeting = ask('Приветствие плагина в логе сервера [Hello World]: ', 'Hello World')
props.pluginGreetingEnable = ask('Нужно ли выводить приветствие(true или false) [true]: ', 'true')
props.pkg = ask('Выберите package для главного класса [com.test]:', 'com.test')

processTemplates 'build.gradle', props
processTemplates 'Config.java', props
processTemplates 'Plugin.java', props
processTemplates 'settings.gradle', props

processTemplates 'src/main/resources/**/*.yml', props

String packageDir = props.pkg.replaceAll(/\./, '/')

moveFileToDirectory(new File(projectDir, 'Plugin.java'), new File(projectDir, "src/main/java/$packageDir"), true)
moveFileToDirectory(new File(projectDir, 'Config.java'), new File(projectDir, "src/main/java/$packageDir"), true)