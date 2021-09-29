@echo off
setlocal

set dir=%CD%
chcp 65001 2>nul >nul

set java_exe=java.exe

if defined JAVA_HOME (
set java_exe="%JAVA_HOME%\bin\java.exe"
)

%java_exe% -jar -Duser.language=en -Duser.dir="%dir%" -DlibsPath="%LCLANG_HOME%\libs" -Dfile.encoding=UTF8 "%LCLANG_HOME%\bin\lclang.jar" %*