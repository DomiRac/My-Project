call gradlew build
if "%ERRORLEVEL%" == "0" goto openruncrud
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:openruncrud
call "C:\Users\domin\Desktop\tasks\runcrud.bat"
if "%ERRORLEVEL%" == "0" goto rungooglechrome

:rungooglechrome
start https://www.google.com/
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.