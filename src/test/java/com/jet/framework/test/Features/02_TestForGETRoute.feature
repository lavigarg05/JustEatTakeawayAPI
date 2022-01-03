#Author: lavigarg05@gmail.com
Feature: Test all GET routes

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
  Scenario Outline: Test to get total comments in an existing post using path parameter
    Given I set "path" parameters
    |id    | 
    | <id> |   
    When I send "GetPostCommentsAPI" with "GET" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify total comments in response body are "<commentCount>"

    Examples: 
       | id    | statusCode  |commentCount |
       |   50  | 200         | 5           |

  @GetCommentsWithQueryParam @Regression
  Scenario Outline: Test to get total comments in an existing post using query parameter
    Given I set "query" parameters
    |postId        | 
    | <postId>     |   
    When I send "GetCommentsAPI" with "GET" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify total comments in response body are "<commentCount>"

    Examples: 
       | postId| statusCode  |commentCount |
       |   50  | 200         | 5           |
              
  @GetAllPosts @Regression
  Scenario Outline: Test to get all existing posts 
 
    When I send "GetAllPostsAPI" with "GET" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify total posts in response body are "<postsCount>"

    Examples: 
       | statusCode  |postsCount   |
			 | 200         |100          |       

