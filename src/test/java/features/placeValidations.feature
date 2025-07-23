Feature: Validating Authorize APIs

@Authorize
Scenario: Verify authorization is Successfully added using authCode
    Given Add authorize payload with "<partnerID>" "<secretCode>"
    When User calls "AuthorizeAPI" with "POST" http request
    Then The API call got success with status code 200
    And The "status" in response body is "SUCCESS"
    And Extract the authCode from response
    
@GetToken    
Scenario: Verify getToken is successfull using authCode
      Given Add getToken payload 
      When User calls "GetTokenAPI" with "POST" http request
      Then The API call got success with status code 200
      And The "status" in response body is "SUCCESS" 
      And Extract the accessToken from response
      
@Register      
Scenario: Registration successfull
      Given Add register payload
      When User calls "RegisterAPI" with "POST" http request
      Then The API call got success with status code 200
      And The "status" in response body is "SUCCESS"
      
Scenario: Registration Unsuccessfull
      Given Add register payload
      When User calls "RegisterAPI" with "POST" http request
      Then The API call got failure with status code 404
      And The "status" in response body is "FAILURE"
      
@Authentication     
Scenario: Authentication successfull
    Given Add authentication payload
    When User calls "AuthenticationAPI" with "POST" http request
    Then The API call got success with status code 200
    And The "status" in response body is "SUCCESS"
    

    