Feature: US B31G1-168: As a user, I should be able to upload files and pictures as messages

  #POSITIVE:
  #supported formats
  #insert files in text
  #removing files
  #simultaneously
  #multiple files
  #drag and drop

  #NEGATIVE:
  #limit for quantity of files
  #file with huge size
  #file with very long name?
  #... 3dots instead of long name which affects design

  Background: user logged in
    Given user logged in as "helpdesk" and launched to the main page

  Scenario Outline: AC1: 1. Verify that the user can upload files and pictures.
                    Supported file formats .pdf, .txt, .jpeg, .png, .docx
    When user on stream page click "message" button
    Then user see upload file button is visible
    When user on stream page click "upload_file" button
    Then user see upload_or_drag_file button is visible
    When user upload "<file>"
    Then user see "<file>" in list of attached files
    When user on stream page click "send" button
    Then user see feed-post with attached "<file>"

    Examples:
      | file  |
      | .pdf  |
      | .txt  |
      | .jpeg |
      | .png  |
      | .docx |
