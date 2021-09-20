;--------------------------------
;Include Modern UI

  !include "MUI2.nsh"

;--------------------------------
;General

  ;Name and file
  Name "Little Cat Language"
  OutFile "windows.exe"
  Unicode True

  ;Default installation folder
  InstallDir "$PROGRAMFILES\lclang"

  ;Request application privileges for Windows Vista
  RequestExecutionLevel admin

;--------------------------------
;Interface Settings

  !define MUI_ABORTWARNING

;--------------------------------
;Pages

  !insertmacro MUI_PAGE_LICENSE "LICENSE"
  !insertmacro MUI_PAGE_DIRECTORY
  !insertmacro MUI_PAGE_INSTFILES

  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES

;--------------------------------
;Languages

  !insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Sections

Section
  CreateDirectory "$INSTDIR"
  CreateDirectory "$INSTDIR\bin"
  CreateDirectory "$INSTDIR\libs"

  SetOutPath "$INSTDIR\bin"
  File lclang.jar

  SetOutPath "WINDIR"
  File lclang.bat

  SetOutPath "$INSTDIR\libs"
  File "libs\"

  nsExec::Exec 'setx LCLANG_HOME "$INSTDIR" /m'

  ReadEnvStr $R0 "PATH"
  StrCpy $R0 "$R0;$INSTDIR\bin"
  System::Call 'Kernel32::SetEnvironmentVariable(t, t) i("PATH", R0).r0'

  WriteUninstaller "$INSTDIR\Uninstall.exe"

SectionEnd

;--------------------------------
;Uninstaller Section

Section "Uninstall"

  ;Bin
  Delete "$INSTDIR\bin\lclang.jar"
  RMDir "$INSTDIR\bin"

  ;Libs
  Delete "$INSTDIR\libs\"
  RMDir "$INSTDIR\libs"


  ;Other
  Delete "$INSTDIR\Uninstall.exe"
  RMDir "$INSTDIR"

  Delete "$WINDIR\lclang.bat"
SectionEnd