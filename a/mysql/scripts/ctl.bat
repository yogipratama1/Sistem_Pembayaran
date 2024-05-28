@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop


"E:\stm\a\mysql\bin\mysqld" --defaults-file="E:\stm\a\mysql\bin\my.ini" --standalone --console
if errorlevel 1 goto error
goto finish

:stop
"E:\stm\a\apache\bin\pv" -f -k mysqld.exe -q

if not exist "E:\stm\a\mysql\data\%computername%.pid" goto finish
echo Delete %computername%.pid ...
del "E:\stm\a\mysql\data\%computername%.pid"
goto finish


:error
echo MySQL could not be started

:finish
exit
