#Author: lavigarg05@gmail.com
Feature: Get_An_Existing_Post

  @GetPost @Regression
  Scenario Outline: Test to get an existing post
    Given I set "path" parameters
    |id    | 
    | <id> |   
    When I send "GetPostAPI" with "GET" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify "id" in response body is "<id>"
    And verify "userId" in response body is "<userId>"
    And verify "title" in response body is "<title>"

    Examples: 
       | id    | statusCode  |userId |title                                                                           |
       |   50  | 200         | 5     |repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem |
       


  @GetComments @Regression
  Scenario Outline: Test to get total comments in an existing post 
    Given I set "path" parameters
    |id    | 
    | <id> |   
    When I send "GetPostCommentsAPI" with "GET" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify total comments in response body are "<commentCount>"

    Examples: 
       | id    | statusCode  |commentCount |
       |   50  | 200         | 5           |

