#Author: lavigarg05@gmail.com
Feature: Test POST route

  @AddPost @Regression
  Scenario Outline: Test to add a new post 
    Given I create a new payload
    | UserId   | Title   | Body   |
    | <UserId> | <Title> | <Body> |
    When I send "AddNewPostAPI" with "POST" http request 
    Then The API call is successfull with status code "<statusCode>"
    And verify "id" in response body is "<id>"
    And verify "title" in response body is "<Title>"
    And verify "body" in response body is "<Body>"
    And verify "userId" in response body is "<UserId>"

    Examples: 
       | id    | statusCode  |UserId   | Title              | Body                 |
       |   101 | 201         | 123     | Create a new post  | This is an awesome ! |
       

