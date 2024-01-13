@Roman
Feature: US B31G1-168: As a user, I should be able to upload files and pictures as messages

  #POSITIVE:
  #supported formats
  #insert files in text
  #removing files
  #simultaneously multiple files

  #NEGATIVE:
  #limit for quantity of files
  #file with huge size
  #file with very long name?
  #... 3dots instead of long name which affects design

  Background: user logged in
    Given user logged in as "helpdesk" and launched to the stream page

  Scenario Outline: AC:1, AC:2
                    #loading files one by one
                    #AC1: Verify that the user can upload files and pictures.
                    #Supported file formats .pdf, .txt, .jpeg, .png, .docx.
                    #AC2: Verify that the user can insert the files and images into the text.

    When user on stream page click "message" button
    Then user see "upload_file" button is visible
    When user on stream page click "upload_file" button
    Then user see "upload_or_drag_file" button is visible
    When user upload "<files>"
    Then user see "<files>" in list of attached files
    When user on stream page click on uploaded file
    Then user see uploaded file status changed to In text
    And user see uploaded "<files>" in text area
    When user on stream page click "send" button
    Then user see feed-post with attached "<files>"
    And user see feed-post with attached "<files>" in text of message

    Examples:
      | files |
      | .pdf  |
      | .txt  |
      | .jpeg |
      | .png  |
      | .docx |

  Scenario Outline: AC 3: Verify that the user can remove files and images at any time before sending.
                      #loading files one by one

    When user on stream page click "message" button
    Then user see "upload_file" button is visible
    When user on stream page click "upload_file" button
    Then user see "upload_or_drag_file" button is visible
    When user upload "<file>"
    Then user see "<file>" in list of attached files
    When user on stream page click on uploaded file
    Then user see uploaded file status changed to In text
    And user see uploaded "<file>" in text area
    When user on stream page click "delete_uploaded_file" button
    Then user see no files attached to the message

    Examples:
      | file  |
      | .pdf  |
      | .txt  |
      | .jpeg |
      | .png  |
      | .docx |


    @Rerun
    Scenario: Verify that user can upload multiple files simultaneously (.pdf, .txt, .jpeg, .png, .docx.)
              #loading files simultaneously

      When user on stream page click "message" button
      Then user see "upload_file" button is visible
      When user on stream page click "upload_file" button
      Then user see "upload_or_drag_file" button is visible
      When user upload multiple files simultaneously
      Then user see simultaneously uploaded files in list of attached files
      When user on stream page click on uploaded file
      Then user see uploaded file status changed to In text
      And user see simultaneously uploaded files in text area
      When user on stream page click "send" button
      Then user see feed-post with simultaneously uploaded files "in attachments"
      And user see feed-post with simultaneously uploaded files "in text"

  @test
    Scenario: User loading 200 .txt files
              #loading files simultaneously

      When user on stream page click "message" button
      Then user see "upload_file" button is visible
      When user on stream page click "upload_file" button
      Then user see "upload_or_drag_file" button is visible
      When user upload 200 .txt files
      Then user see 200 uploaded files in list of attached files
      When user on stream page click on uploaded file
      Then user see uploaded file status changed to In text
      And user see 200 uploaded .txt files in text area
      When user on stream page click "send" button
      Then user see feed-post with 200 uploaded .txt files "in attachments"
      And user see feed-post with 200 uploaded .txt files "in text"


