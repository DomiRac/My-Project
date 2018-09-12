call gradlew build
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:openruncrud
call "C:\Users\domin\Desktop\tasks\runcrud.bat"
if "%ERRORLEVEL%" == "0" goto fail

:rungooglechrome
start chrome https://www.google.co.in/
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.