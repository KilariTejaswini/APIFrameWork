Feature: Validating Authorize APIs

@Authorize
Scenario Outline: Verify authorization is Successfully added using authCode
    Given Add authorize payload with "<partnerId>" "<secretCode>"
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
      
#@register
#Scenario: Verify User is successfully register using accessToken
 #     Given Add register payload
  #    When User calls "RegisterAPI" with "POST" http request
   #   Then The API call got success with status code 200
    #  And The "status" in response body is "SUCCESS"
     
      
