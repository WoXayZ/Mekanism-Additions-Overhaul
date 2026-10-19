@rem Gradle startup script
@echo off
set DIR=%~dp0
set APP_HOME=%DIR%
java -classpath "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
