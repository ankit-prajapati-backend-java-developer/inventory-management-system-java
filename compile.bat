@echo off
javac -d out -sourcepath src src\com\inventory\*.java src\com\inventory\model\*.java
if %errorlevel% neq 0 exit /b %errorlevel%
echo Compile OK.
