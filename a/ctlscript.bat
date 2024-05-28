@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop

if exist E:\stm\a\hypersonic\scripts\ctl.bat (start /MIN /B E:\stm\a\server\hsql-sample-database\scripts\ctl.bat START)
if exist E:\stm\a\ingres\scripts\ctl.bat (start /MIN /B E:\stm\a\ingres\scripts\ctl.bat START)
if exist E:\stm\a\mysql\scripts\ctl.bat (start /MIN /B E:\stm\a\mysql\scripts\ctl.bat START)
if exist E:\stm\a\postgresql\scripts\ctl.bat (start /MIN /B E:\stm\a\postgresql\scripts\ctl.bat START)
if exist E:\stm\a\apache\scripts\ctl.bat (start /MIN /B E:\stm\a\apache\scripts\ctl.bat START)
if exist E:\stm\a\openoffice\scripts\ctl.bat (start /MIN /B E:\stm\a\openoffice\scripts\ctl.bat START)
if exist E:\stm\a\apache-tomcat\scripts\ctl.bat (start /MIN /B E:\stm\a\apache-tomcat\scripts\ctl.bat START)
if exist E:\stm\a\resin\scripts\ctl.bat (start /MIN /B E:\stm\a\resin\scripts\ctl.bat START)
if exist E:\stm\a\jboss\scripts\ctl.bat (start /MIN /B E:\stm\a\jboss\scripts\ctl.bat START)
if exist E:\stm\a\jetty\scripts\ctl.bat (start /MIN /B E:\stm\a\jetty\scripts\ctl.bat START)
if exist E:\stm\a\subversion\scripts\ctl.bat (start /MIN /B E:\stm\a\subversion\scripts\ctl.bat START)
rem RUBY_APPLICATION_START
if exist E:\stm\a\lucene\scripts\ctl.bat (start /MIN /B E:\stm\a\lucene\scripts\ctl.bat START)
if exist E:\stm\a\third_application\scripts\ctl.bat (start /MIN /B E:\stm\a\third_application\scripts\ctl.bat START)
goto end

:stop
echo "Stopping services ..."
if exist E:\stm\a\third_application\scripts\ctl.bat (start /MIN /B E:\stm\a\third_application\scripts\ctl.bat STOP)
if exist E:\stm\a\lucene\scripts\ctl.bat (start /MIN /B E:\stm\a\lucene\scripts\ctl.bat STOP)
rem RUBY_APPLICATION_STOP
if exist E:\stm\a\subversion\scripts\ctl.bat (start /MIN /B E:\stm\a\subversion\scripts\ctl.bat STOP)
if exist E:\stm\a\jetty\scripts\ctl.bat (start /MIN /B E:\stm\a\jetty\scripts\ctl.bat STOP)
if exist E:\stm\a\hypersonic\scripts\ctl.bat (start /MIN /B E:\stm\a\server\hsql-sample-database\scripts\ctl.bat STOP)
if exist E:\stm\a\jboss\scripts\ctl.bat (start /MIN /B E:\stm\a\jboss\scripts\ctl.bat STOP)
if exist E:\stm\a\resin\scripts\ctl.bat (start /MIN /B E:\stm\a\resin\scripts\ctl.bat STOP)
if exist E:\stm\a\apache-tomcat\scripts\ctl.bat (start /MIN /B /WAIT E:\stm\a\apache-tomcat\scripts\ctl.bat STOP)
if exist E:\stm\a\openoffice\scripts\ctl.bat (start /MIN /B E:\stm\a\openoffice\scripts\ctl.bat STOP)
if exist E:\stm\a\apache\scripts\ctl.bat (start /MIN /B E:\stm\a\apache\scripts\ctl.bat STOP)
if exist E:\stm\a\ingres\scripts\ctl.bat (start /MIN /B E:\stm\a\ingres\scripts\ctl.bat STOP)
if exist E:\stm\a\mysql\scripts\ctl.bat (start /MIN /B E:\stm\a\mysql\scripts\ctl.bat STOP)
if exist E:\stm\a\postgresql\scripts\ctl.bat (start /MIN /B E:\stm\a\postgresql\scripts\ctl.bat STOP)

:end

