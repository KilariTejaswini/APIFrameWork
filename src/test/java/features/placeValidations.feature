Feature: Validating Authorize APIs

@Authorize
Scenario Outline: Verify authorization is Successfully added using authCode
    Given Add authorize payload with "<partnerId>" "<secretCode>"
    When User calls "AuthorizeAPI" with "POST" http request
    Then The API call got success with status code 200
    And The "status" in response body is "SUCCESS"
    And Capture the authCode from response
    
Examples: 
      | partnerId | secretCode     |
      | jokaroom  |mVfbZCu3rh3uw7d |     
      
      
@GetToken 
Scenario: Verify getToken is successfull using authCode
      Given Add getToken payload using "<partnerId>" 
      When User calls "GetTokenAPI" with "POST" http request
      Then The API call got success with status code 200
      And The "status" in response body is "SUCCESS" 
      And Capture the accessToken from response
      
