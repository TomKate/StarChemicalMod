setlocal 
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_172
call gradlew setupDecompWorkspace eclipse
endlocal
echo build was finish
pause