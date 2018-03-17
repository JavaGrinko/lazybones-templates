import static org.apache.commons.io.FileUtils.moveFileToDirectory

Map<String,String> props = [:]

props.pluginName = ask('������� �������� ������� ��� �������� � CamelCase [TestPlugin]): ', 'TestPlugin')
props.pluginNameLowercase = props.pluginName.toLowerCase()
props.pluginVersion = ask('������� ������ ������� [1.0.0]: ', '1.0.0')
props.pluginAuthor = ask('������� ������ ������� � ������� ��� <�����> [User <user@test.com>]: ', 'User <user@test.com>')
props.pluginDescription = ask('������� �������� ������� [Test plugin]: ', 'Test plugin')
props.pluginWebsite = ask('������� ���� ������� [google.com]: ', 'google.com')
props.pluginGreeting = ask('����������� ������� � ���� ������� [Hello World]: ', 'Hello World')
props.pluginGreetingEnable = ask('����� �� �������� �����������(true ��� false) [true]: ', 'true')
props.pkg = ask('�������� package ��� �������� ������ [com.test]:', 'com.test')

processTemplates 'build.gradle', props
processTemplates 'Config.java', props
processTemplates 'Plugin.java', props
processTemplates 'settings.gradle', props

processTemplates 'src/main/resources/**/*.yml', props

String packageDir = props.pkg.replaceAll(/\./, '/')

moveFileToDirectory(new File(projectDir, 'Plugin.java'), new File(projectDir, "src/main/java/$packageDir"), true)
moveFileToDirectory(new File(projectDir, 'Config.java'), new File(projectDir, "src/main/java/$packageDir"), true)