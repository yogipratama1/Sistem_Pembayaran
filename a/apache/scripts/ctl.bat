@echo off

if not ""%1"" == ""START"" goto stop

cmd.exe /C start /B /MIN "" "E:\stm\a\apache\bin\httpd.exe"

if errorlevel 255 goto finish
if errorlevel 1 goto error
goto finish

:stop
"E:\stm\a\apache\bin\pv" -f -k httpd.exe -q
if not exist "E:\stm\a\apache\logs\httpd.pid" GOTO finish
del "E:\stm\a\apache\logs\httpd.pid"
goto finish

:error
echo Error starting Apache

:finish
exit
