*** Settings ***
Documentation   Simple example using SeleniumLibrary.
Library         SeleniumLibrary

*** Variables ***
${LOGIN URL}    http://localhost:8080/
${BROWSER}      Chrome

*** Test Cases ***
Valid Login
    Open Browser to test
    Input Username    kukkikkpl
    Input Password    12345678
    Submit Credentials
    Welcome Page Should Be Open
    [Teardown]    Close Browser

Invalid Login
    Open Browser to test
    Input Username    kukkikkpl
    Input Password    87654321
    Submit Credentials
    Still on login page
    [Teardown]    Close Browser



*** Keywords ***
Open Browser to test
    Open Browser    ${LOGIN URL}    ${BROWSER}
    Maximize Browser Window
    Click Button    id:login-signup

Input Username
    [Arguments]    ${username}
    Input Text    id:username    ${username}

Input Password
    [Arguments]    ${password}
    Input Text    id:password    ${password}

Submit Credentials
    Click Button    id:login-button

Welcome Page Should Be Open
    Wait Until Page Does Not Contain Element   id:login-button
    Title Should Be    Welcome

Still on login page
    Title Should Be    Login