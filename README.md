Goal
---
The aim of the SDK is to demonstrate the flow of Open Banking *AISP/PISP* APIs with the help of Sandbox environment with default TLS configuration or your own configured Open Banking certificates(MATLS).
The SDK can be used by third party providers to integrate and test OB APIs.

The SDK application can run in two different modes, TLS (Basic Authentication) as default, or MATLS (OAuth2). All Open Banking APIs in production use MATLS and therefor it is recommended to use MATLS in production. The SDK is provided with TLS(ClientId/Client Secret) as default to get application quick started. For MATLS you need to obtain Open Banking Transport and Signing Certs. Please refer to [How to run SDK with MATLS](#how-to-run-sdk-with-matls)

### Modules
For maximum flexibility, the SDK is divided into three modules: Core, Remote and Web. Core and Remote are essential modules if you would like to use SDK to build your own microservice. An example of which is provided in the Web Module.

#### Core
The core module consists of the model structure for AISP and PISP data. The information returned via the APIs are structured into relevant POJOs for ease of access and readability.

#### Remote
The remote module establishes connection with the APIs. It includes construction of headers, configuring security MATLS for sending requests and accepting responses. The requests are actioned upon and connected to internal servers to fetch the required data.

#### Web
The web module acts as an interface connecting the APIs to the Sandbox environment. It houses the controllers of AISP/PISP APIs.

The SDK's default configuration is with Sandbox(in web/resources/application.yml), you don't need to give any credentials or certificates, just run the main class inside web\comm.bankofapis\RestClientApplication directly.
Below are configurable property, in the case you want to use your own.

## Properties
---

##### Client Properties

| *Property*      |         |
| ------------- |---------|
| id          | The client_id is a public identifier for apps. Even though it’s public, it’s best that it isn’t guessable by third parties, so many implementations use something like a 32-character hex string.       |
| redirectUri |     After a user successfully authorizes an application, the authorization server will redirect the user back to the application with either an authorization code or access token in the URL.    |
| financialId      |       It is the unique identifier of the desired financial institution to interact, assigned by the service bureau where the API is provided by a service bureau which uses the same endpoint for multiple institutions.  |
| state      |      The state parameter preserves some state object set by the client in the Authorization request and makes it available to the client in the response.  |
| authorizationUsername      |    The client is providing its identification to IAM, as username.   |
| authorizationPassword      |    The client is providing the password to IAM.   |
| tokenUrl      |    This is a IAM url to get token for AISP/PISP APIs for a given client.   |


##### TLS Properties

|  *Property* |         |
| ------------- |---------|
| alias      |    A client intending to do mutual TLS (for OAuth client authentication and/or to acquire or use certificate-bound tokens) when making a request directly to the authorization server must use the alias URL of the endpoint within the mtls_endpoint_aliases, when present, in preference to the endpoint URL of the same name at top-level of metadata.      |
| truststore      |   Truststores are repositories of security certificates used for TLS encryption. It contains certificates used to verify certificates received as part of TLS handshaking. Provide the truststore location and password     |
| keystore      |   A Java KeyStore is a repository of security certificates – either authorization certificates or public key certificates – plus corresponding private keys, used for instance in SSL encryption. Provide the keystore location and password.     |

##### AISP Properties

|        |     *Property* |         |
| ------------- | ------------- |---------|
|    Target     | context      |   The authentication context and method used when the end user originally authenticated, and will remain unchanged for the JWT access tokens issued within the context of that session      |
|               | baseUri      |   You can request authorization codes and access tokens by appending only the authorize or token endpoints to the Authentication Base URI.      |
|               | audience      |      The audience of a token is the intended recipient of the token.   |

##### PISP Properties

|        |     *Property* |         |
| ------------- | ------------- |---------|
|    Target     | context      |       Context path for domestic payment  |
|               | baseUri      |   You can request authorization codes and access tokens by appending only the authorize or token endpoints to the Authentication Base URI.      |
|               | audience      |      The audience of a token is the intended recipient of the token.   |

---

# SDK example setup
---
## Preliminary Steps

1. Browse to the RBS sandbox https://developer.rbs.useinfinite.io/
2. Register an account and verify email address to login
3. On the dashboard, click on the pre-created demo app (demo-app-...)
4. Under APIs -> Version 3.1.0 of CMA9 Accounts API, click 'Request Access'...
5. Enable 'Allow security' and 'Allow Tpp' to programmatically authorise User consents'


## How to bootup the application

1.    Clone this repository.
2.    Open IntelliJ, Goto File > New > Project from Existing Resources
3.    Select the cloned Repository > Check Import project from external model and Select Maven
4.    Keep on clicking Next till it detects the pom file and then select Finish. The project would be loaded and displayed on the project pane.
5.    Open terminal in the IDE and run *mvn clean install*, upon completion, right click on the project > Goto Maven > Reimport
6.    Run the main method of *web->RestClientApplication*   

      

>#### *Note*
>- For eclipse, follow maven project setup steps from [here](https://javapapers.com/java/import-maven-project-into-eclipse/).
>- To GET/POST the APIs, download [Postman](https://www.postman.com/downloads/).
>- You have to go in Preferences or Settings > General menu in HEADERS column and make sure that Automatically follow redirects is set to ON

7. Download Postman API collections of PISP/AISP open and prod APIs and postman environments from inside the project {openbanking-java-sdk-example/postmancollections} and import all collections.

## AISP Demo
---
1. Select environment(sandbox) on the top right in Postman.
2. Run the first *token* and than *AISP Consent Setup* API from AispSDK collection.
http://localhost:8080/open-banking/v3.1/aisp/account-access-consents
----------------------Request Body---------------------
{
	"permission" : ["ReadAccountsBasic", "ReadAccountsDetail", "ReadBalances",
                "ReadBeneficiariesBasic", "ReadBeneficiariesDetail", "ReadDirectDebits",
                "ReadProducts", "ReadStandingOrdersBasic", "ReadStandingOrdersDetail",
                "ReadTransactionsBasic", "ReadTransactionsCredits", "ReadTransactionsDebits",
                "ReadTransactionsDetail"]
}

----------------------Response---------------------
https://api.rbs.useinfinite.io/authorize?client_id=2AO66SW3w0Wespk6Qfx6smSfdDhcdH6KSG1tPEOdBMg=&response_type=code id_token&scope=openid accounts&redirect_uri=http://redirect.acc.com&state=ABC&request=69dea1b8-6723-436b-9611-764e9d386c08

3. Run the *authUrl* in browser. Login using the Customer Number and password. Select account/s and confirm access. Copy the *code* from the redirected url.
>Customer Number : 123456789012, 
 Password : 572436
 
http://redirect.acc.com/#code=0f9365cd-84e7-4efa-aad5-bc148e1a280e&id_token=eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImpSdzQwV0FFbElyWXVJX2cza1VyYUs5elhTcyJ9.eyJzdWIiOiIyQU82NlNXM3cwV2VzcGs2UWZ4NnNtU2ZkRGhjZEg2S1NHMXRQRU9kQk1nPSIsImFjciI6InVybjpvcGVuYmFua2luZzpwc2QyOnNjYSIsImF1ZCI6IjJBTzY2U1czdzBXZXNwazZRZng2c21TZmREaGNkSDZLU0cxdFBFT2RCTWc9IiwiY19oYXNoIjoiUmtMUkNsNDVOcHdYWmhSYWd3cGdhdyIsIm9wZW5iYW5raW5nX2ludGVudF9pZCI6IjQ1NDk1NTAwLWJmZTItNDgxNS05NmUwLWE4NmMzMjM1ZTljNSIsInNfaGFzaCI6InRkUUVYRDlHYjZrZjRzeHF2bmtqS2ciLCJpc3MiOiJyYnMudXNlaW5maW5pdGUuaW8iLCJleHAiOjE2MTI4NTI2NDgsInRva2VuX3R5cGUiOiJJRF9UT0tFTiIsImlhdCI6MTU4MTMxNjY0OCwianRpIjoiNzJhNzM0NWQtYmNiOS00ZDgwLWJmMGEtODFhNGU4ZWNjZTFhIn0.qrW82h_2vazetkc06XvgJvAtle1Iqi2DcygRkdB_RU732bBHspV1jxj7_bW9vjSzadTUZ_33ugRaxblux-s_yNk-dZr78J2VsxfYlThTC7pqaKRBZYw1fRvbuOC7hKsF6IX0SESIyJ-oz1Okj1lgFJdiumM8JupsovyywSzlCna8p7fvmf4uv75lPH7vS1MYgEfpH-8UM_3q8KAV66j-OlyLKPxV5omvHfe783zzMoAmc6sAFpwY9EHlb5rfjcv8gwSQA5qBagjIBENjwVRa3BparZkro40Y3nsMFxpQCTtXB5o4u8vczp8QG02BpbrDDKwdfry5AlvBUnn5pmIK1w&state=ABC 

4. Pass the *code* to the OBToken API. This will generate the Access and refresh tokens.
5. To get the Account information for a single id. Run the AccountId API, with the account id in path param.

----------------------Request---------------------
http://localhost:8080/open-banking/v3.1/aisp/accounts/***Append Id Here***

----------------------Response Body---------------------
{
    "Data": {
        "Account": [
            {
                "AccountId": ***Account Id***,
                "Currency": "GBP",
                "AccountType": "Personal",
                "AccountSubType": "CurrentAccount",
                "Description": "Personal",
                "Nickname": "Debit Account - RBS - Sydney",
                "Account": [
                    {
                        "SchemeName": "UK.OBIE.SortCodeAccountNumber",
                        "Identification": ***Identification Value***,
                        "Name": "Debit Account - RBS - Sydney"
                    }
                ]
            }
        ]
    },
    "Links": {
        "Self": "https://ob.rbs.useinfinite.io/open-banking/v3.1/aisp/accounts/***Account Id***"
    },
    "Meta": {
        "TotalPages": 1
    }
} 
6. Similarly you can get Account List, Balances by Id, Direct Debits, Standing Orders, Transaction Lists and Products by Id.

## PISP Demo
 ---
1. Select environment on the top right in Postman.
2. Run the first *Retrieve access token for Payment request Copy* API from PispSDK collection.
http://localhost:8080/token

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHAiOiJUZXN0IE1BVExTIiwib3JnIjoidGVhbS5hY2Mub3JnIiwiaXNzIjoicmJzLnVzZWluZmluaXRlLmlvIiwidG9rZW5fdHlwZSI6IkFDQ0VTU19UT0tFTiIsImNsaWVudF9pZCI6IjM2ZWYyYmM3LWEyMzUtNDBiMi04YjExLTk1ODRlZTZhNTZlNSIsInRyYW5zcG9ydF9jZXJ0X2ZwIjoiMzExMWNmM2NkZTNkOThhZWZkMjQ1ODhjYmQ4ZDk1MmQxMDZkNDliNyIsIm1heF9hZ2UiOjg2NDAwLCJhdWQiOiIzNmVmMmJjNy1hMjM1LTQwYjItOGIxMS05NTg0ZWU2YTU2ZTUiLCJzY29wZSI6InBheW1lbnRzIiwiZXhwIjoxNTgxMzIwMjY1LCJpYXQiOjE1ODEzMTk5NjUsImp0aSI6IjQ4NjExMDU5LTE1ZmItNDUzMy1hN2U0LTliYTE1OGZmM2YxNyIsInRlbmFudCI6IlJCUyJ9.ASO2r2ncOgRm9g3qOq9ZsKgHIdSq_EXC_XTPxFG7uBDkcFEfXSKfhmGk3eDfh0dsa7Jmgs34M2g0dObCsOrLLCHkQKufnqpoo1NNvIsNqhDVJYweqw0X9pClxPlyFL9QoGHz4q7QupYiQHKWyJNUSbNTFvXku1d8vU_NM12_kenF9sz0VtAjHZ8M3qJbKtLlivspqmUWIuX4sCvCP3MMuLWk1L41d9mlYMuDNQhUNArVq3U6d7ez9SnBtByltIuNkBa4h9XyUdY71KyXwx7753p5GYVylAFq13TvV_Vdor4tLYaf9sDbW574PDVjrPeVtmLWmyUbJFTi4zumKY2pIg",
    "refresh_token": null,
    "id_token": null,
    "token_type": "Bearer",
    "expires_in": 300,
    "scope": "payments"
}

3. To post domestic payment consent request, change the x-idempotency-key header to an unique code.
 http://localhost:8080/open-banking/v3.1/pisp/domestic-payment-consents

----------------------Request Body---------------------
{
  "Data": {
    "Initiation": {
      "InstructionIdentification": "instr-identification",
      "EndToEndIdentification": "e2e-identification",
      "InstructedAmount": {
        "Amount": "50.00",
        "Currency": "{{psuDebtorAccountCurrency}}"
      },
      "DebtorAccount": null,
      "CreditorAccount": {
        "SchemeName": "IBAN",
        "Identification": "BE56456394728288",
        "Name": "ACME DIY",
        "SecondaryIdentification": "secondary-identif"
      },
      "RemittanceInformation": {
        "Unstructured": "Tools",
        "Reference": "Tools"
      }
    }
  },
  "Risk": {
    "PaymentContextCode": "EcommerceGoods",
    "MerchantCategoryCode": null,
    "MerchantCustomerIdentification": null,
    "DeliveryAddress": null
  }
} 

---------------------Pisp Domestic Consent Payment Response-----------------
 {
    "Data": {
        "ConsentId": "1f8af849-2536-42bd-acf5-4882da40446e",
        "CreationDateTime": "2020-02-10T07:37:04.65Z",
        "Status": "AwaitingAuthorisation",
        "StatusUpdateDateTime": "2020-02-10T07:37:04.653Z",
        "CutOffDateTime": null,
        "ExpectedExecutionDateTime": null,
        "ExpectedSettlementDateTime": null,
        "Charges": null,
        "Initiation": {
            "InstructionIdentification": "instr-identification",
            "EndToEndIdentification": "e2e-identification",
            "LocalInstrument": null,
            "InstructedAmount": {
                "Amount": "50.00",
                "Currency": "GBP"
            },
            "DebtorAccount": null,
            "CreditorAccount": {
                "SchemeName": "IBAN",
                "Identification": "BE56456394728288",
                "Name": "ACME DIY",
                "SecondaryIdentification": "secondary-identif"
            },
            "CreditorPostalAddress": null,
            "RemittanceInformation": {
                "Unstructured": "Tools",
                "Reference": "Tools"
            },
            "SupplementaryData": null
        },
        "Authorisation": null
    },
    "Risk": {
        "PaymentContextCode": "EcommerceGoods",
        "MerchantCategoryCode": null,
        "MerchantCustomerIdentification": null,
        "DeliveryAddress": null
    },
    "Links": {
        "Self": "https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payment-consents/1f8af849-2536-42bd-acf5-4882da40446e",
        "First": null,
        "Prev": null,
        "Next": null,
        "Last": null
    },
    "Meta": {
        "TotalPages": 1,
        "FirstAvailableDateTime": null,
        "LastAvailableDateTime": null
    }
}

4. Now get the Authorise Consent URL and run the *authUrl* in a browser and it redirect to you Open Banking/sandbox IAM page there you need to login using the customer number and password.
>Customer Number : 123456789012, 
 Password : 572436
 http://localhost:8080/open-banking/v3.1/pisp/authorization.oauth2?request={{consentId}}

{
    "authUrl": "https://api.rbs.useinfinite.io/authorize?client_id=2AO66SW3w0Wespk6Qfx6smSfdDhcdH6KSG1tPEOdBMg=&response_type=code%20id_token&scope=openid%20payments&redirect_uri=http%3A%2F%2Fredirect.acc.com&state=ABC&request=1f8af849-2536-42bd-acf5-4882da40446e&authorization_username=123456789012%40team.acc.org&authorization_account=50000012345601",
    "pkceChallenge": null
} 

5. Select account and confirm payment. Copy the *code* from the redirected url.
 http://redirect.acc.com/#code=0f9365cd-84e7-4efa-aad5-bc148e1a280e&id_token=eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImpSdzQwV0FFbElyWXVJX2cza1VyYUs5elhTcyJ9.eyJzdWIiOiIyQU82NlNXM3cwV2VzcGs2UWZ4NnNtU2ZkRGhjZEg2S1NHMXRQRU9kQk1nPSIsImFjciI6InVybjpvcGVuYmFua2luZzpwc2QyOnNjYSIsImF1ZCI6IjJBTzY2U1czdzBXZXNwazZRZng2c21TZmREaGNkSDZLU0cxdFBFT2RCTWc9IiwiY19oYXNoIjoiUmtMUkNsNDVOcHdYWmhSYWd3cGdhdyIsIm9wZW5iYW5raW5nX2ludGVudF9pZCI6IjQ1NDk1NTAwLWJmZTItNDgxNS05NmUwLWE4NmMzMjM1ZTljNSIsInNfaGFzaCI6InRkUUVYRDlHYjZrZjRzeHF2bmtqS2ciLCJpc3MiOiJyYnMudXNlaW5maW5pdGUuaW8iLCJleHAiOjE2MTI4NTI2NDgsInRva2VuX3R5cGUiOiJJRF9UT0tFTiIsImlhdCI6MTU4MTMxNjY0OCwianRpIjoiNzJhNzM0NWQtYmNiOS00ZDgwLWJmMGEtODFhNGU4ZWNjZTFhIn0.qrW82h_2vazetkc06XvgJvAtle1Iqi2DcygRkdB_RU732bBHspV1jxj7_bW9vjSzadTUZ_33ugRaxblux-s_yNk-dZr78J2VsxfYlThTC7pqaKRBZYw1fRvbuOC7hKsF6IX0SESIyJ-oz1Okj1lgFJdiumM8JupsovyywSzlCna8p7fvmf4uv75lPH7vS1MYgEfpH-8UM_3q8KAV66j-OlyLKPxV5omvHfe783zzMoAmc6sAFpwY9EHlb5rfjcv8gwSQA5qBagjIBENjwVRa3BparZkro40Y3nsMFxpQCTtXB5o4u8vczp8QG02BpbrDDKwdfry5AlvBUnn5pmIK1w&state=ABC


6. Pass the code to generate OBToken from API.
http://localhost:8080/token

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHAiOiJUZXN0IE1BVExTIiwib3JnIjoidGVhbS5hY2Mub3JnIiwiaXNzIjoicmJzLnVzZWluZmluaXRlLmlvIiwidG9rZW5fdHlwZSI6IkFDQ0VTU19UT0tFTiIsImNsaWVudF9pZCI6IjM2ZWYyYmM3LWEyMzUtNDBiMi04YjExLTk1ODRlZTZhNTZlNSIsInRyYW5zcG9ydF9jZXJ0X2ZwIjoiMzExMWNmM2NkZTNkOThhZWZkMjQ1ODhjYmQ4ZDk1MmQxMDZkNDliNyIsIm1heF9hZ2UiOjg2NDAwLCJhdWQiOiIzNmVmMmJjNy1hMjM1LTQwYjItOGIxMS05NTg0ZWU2YTU2ZTUiLCJ1c2VyX2lkIjoiMTIzNDU2Nzg5MDEyQHRlYW0uYWNjLm9yZyIsImdyYW50X2lkIjoiMjM0MjBhMTktODljYS00NTM2LWFhMTYtNjc2YzA0NWNmOTU5Iiwic2NvcGUiOiJwYXltZW50cyBvcGVuaWQiLCJjb25zZW50X3JlZmVyZW5jZSI6ImQyNmMxZmVjLTMzYzQtNDU1Yy1iZmFlLTU2NzVhMGIxMTM4YiIsImV4cCI6MTU4MTMyMTA2NiwiaWF0IjoxNTgxMzIwNzY2LCJqdGkiOiI1ZTMxYzI3Ny00YWJkLTQ4ZDAtOGE1ZC02NzAzZWY2M2JmMTMiLCJ0ZW5hbnQiOiJSQlMifQ.SPgAjJUqKpbhEARXRP8W7kRLMx3EGiPydcCZfQQ94wxOHL9mZlpk7bbYT55YR_4VfhaeXDLy4FjtQXGcJlTOzcNWeug7ktOBrEQqlr5bRhFteDtQOFQDOYvHdcGX0R77NC6ZLpEKc56WMOyUC-V271AonT7xFdDVLIG5rhFlFlFh1jvrCZHhWSXFJ0N5xuFVdXQNm767N6yqnnpfEEKSWpJ7l-Jnszt-xiMccn0o8itKSPa9cng3BMMQrgPKxepoHOP1ZKueuUYLDMWsDeYwxfwqxFSf9XLGyWjAn1lgWXIrLb7x0RsOKe3wYxsAo8xoJBXuvpfEqaG3YhlWYyH1Fg",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHAiOiJUZXN0IE1BVExTIiwib3JnIjoidGVhbS5hY2Mub3JnIiwiaXNzIjoicmJzLnVzZWluZmluaXRlLmlvIiwidG9rZW5fdHlwZSI6IlJFRlJFU0hfVE9LRU4iLCJjbGllbnRfaWQiOiIzNmVmMmJjNy1hMjM1LTQwYjItOGIxMS05NTg0ZWU2YTU2ZTUiLCJ0cmFuc3BvcnRfY2VydF9mcCI6IjMxMTFjZjNjZGUzZDk4YWVmZDI0NTg4Y2JkOGQ5NTJkMTA2ZDQ5YjciLCJtYXhfYWdlIjo4NjQwMCwiYXVkIjoiMzZlZjJiYzctYTIzNS00MGIyLThiMTEtOTU4NGVlNmE1NmU1IiwidXNlcl9pZCI6IjEyMzQ1Njc4OTAxMkB0ZWFtLmFjYy5vcmciLCJncmFudF9pZCI6IjIzNDIwYTE5LTg5Y2EtNDUzNi1hYTE2LTY3NmMwNDVjZjk1OSIsInNjb3BlIjoicGF5bWVudHMgb3BlbmlkIiwiY29uc2VudF9yZWZlcmVuY2UiOiJkMjZjMWZlYy0zM2M0LTQ1NWMtYmZhZS01Njc1YTBiMTEzOGIiLCJpYXQiOjE1ODEzMjA3NjYsImp0aSI6ImJiZmUzYTdmLWM2YTctNGI4OS1iNWNiLTBjY2YwZDRlNWIwMyIsInRlbmFudCI6IlJCUyJ9.IYYaRFhg_ZGa5ZsA0WZGppmqgU1VIisXs9DQgjlSKyqHW46s5M0PiyEQrvzEctMhMBbkX8clRwic-wuDIvP57iRfNCqpvIN3lxLYOkqfD-DYLj4Oo4oaghm7a-sYO2M4qnzzlSXQh_C4MBfHq1gjb-lPlqs9zDscxGs1zOdQQ_WZlbQisDp6eiDipsGp1YAfRqJco8Tqc6mRcRR_F-WoqAtpHpIkUej4ZXhSt4AsB4_JBcjK5vdbZwxj3NsYHt5erpLCCzOg_KvceyflOtxIRc31V15TtZ959lFBZ5bgySu75a5pr44sD_4YJjLTS8JrndLilqskwWfCZ0i9X14fEQ",
    "id_token": "eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImpSdzQwV0FFbElyWXVJX2cza1VyYUs5elhTcyJ9.eyJzdWIiOiIyQU82NlNXM3cwV2VzcGs2UWZ4NnNtU2ZkRGhjZEg2S1NHMXRQRU9kQk1nPSIsImFjciI6InVybjpvcGVuYmFua2luZzpwc2QyOnNjYSIsImF1ZCI6IjJBTzY2U1czdzBXZXNwazZRZng2c21TZmREaGNkSDZLU0cxdFBFT2RCTWc9IiwiY19oYXNoIjoiSndTTkp4RXUxdEd4cU0zNHZUdTk5dyIsIm9wZW5iYW5raW5nX2ludGVudF9pZCI6ImVhYWVmMDExLTU4YzAtNDBlMi04YTY5LTNiYzMzZTYxOTllYyIsInNfaGFzaCI6InRkUUVYRDlHYjZrZjRzeHF2bmtqS2ciLCJpc3MiOiJyYnMudXNlaW5maW5pdGUuaW8iLCJleHAiOjE2MTI4NTY3NTIsInRva2VuX3R5cGUiOiJJRF9UT0tFTiIsImlhdCI6MTU4MTMyMDc1MiwianRpIjoiM2UyMDlmOGMtOGMzMi00MzFmLWI0NzktMDA1NThhODAxNDAzIn0.aTzyAxuuVG7Yc76OQgcbCM_K8QMWZAg0GMZJxAHqMdCKNa2YKpYmepxEd8ZsfbHXh60nKbtA9nTBH9fLZvFZoAYtSR8uTUtAKQbMP-qkyzlenWC8q5YUcb_N4ZpJbMdFD5mbfurI4FY5jvEmKtoFKVNYk-VSnJzbM27PTo8MsmlQWKnupsrmyroNifoM2rPuxSz-hKLvD4ymn0R5AaVMMuzQx3nNGF-E0Dmzwej3M7UjcCpzcZVgrSG3pqr2JMXSk9Un_L3FIuXhtlDFfWoX6k2j9P-b19c5pmRBAQp9UV8v5JrHTlpANigR9Se5ELixybY2aTKZqvBF_I2j0nkjuw",
    "token_type": "Bearer",
    "expires_in": 300,
    "scope": "payments openid"
}
7. To Post the Payment, run the domestic-payments API and pass the modified x-idempotency-key from domestic payment consent request.
http://localhost:8080/open-banking/v3.1/pisp/domestic-payments

----------------------------Request Body-------------------------
{
  "Data": {
  	"ConsentId": "{{consentId}}",
    "Initiation": {
      "InstructionIdentification": "instr-identification",
      "EndToEndIdentification": "e2e-identification",
      "InstructedAmount": {
        "Amount": "50.00",
        "Currency": "{{psuDebtorAccountCurrency}}"
      },
      "DebtorAccount": null,
      "CreditorAccount": {
        "SchemeName": "IBAN",
        "Identification": "BE56456394728288",
        "Name": "ACME DIY",
        "SecondaryIdentification": "secondary-identif"
      },
      "RemittanceInformation": {
        "Unstructured": "Tools",
        "Reference": "Tools"
      }
    }
  },
  "Risk": {
    "PaymentContextCode": "EcommerceGoods",
    "MerchantCategoryCode": null,
    "MerchantCustomerIdentification": null,
    "DeliveryAddress": null
  }
} 

----------------------Payment Submission response--------------------

{
    "Data": {
        "DomesticPaymentId": "eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "ConsentId": "eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "CreationDateTime": "2020-02-10T07:46:27.251Z",
        "Status": "Rejected",
        "StatusUpdateDateTime": "2020-02-10T07:46:27.26Z",
        "ExpectedExecutionDateTime": null,
        "ExpectedSettlementDateTime": null,
        "Charges": null,
        "Initiation": {
            "InstructionIdentification": "instr-identification",
            "EndToEndIdentification": "e2e-identification",
            "LocalInstrument": null,
            "InstructedAmount": {
                "Amount": "50.00",
                "Currency": "GBP"
            },
            "DebtorAccount": null,
            "CreditorAccount": {
                "SchemeName": "IBAN",
                "Identification": "BE56456394728288",
                "Name": "ACME DIY",
                "SecondaryIdentification": "secondary-identif"
            },
            "CreditorPostalAddress": null,
            "RemittanceInformation": {
                "Unstructured": "Tools",
                "Reference": "Tools"
            },
            "SupplementaryData": null
        },
        "MultiAuthorisation": null
    },
    "Links": {
        "Self": "https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payments/eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "First": null,
        "Prev": null,
        "Next": null,
        "Last": null
    },
    "Meta": {
        "TotalPages": 1,
        "FirstAvailableDateTime": null,
        "LastAvailableDateTime": null
    }
} 

8. To check the payment status append the domesticPaymentId to the PaymentStatus API.
http://localhost:8080/open-banking/v3.1/pisp/domestic-payments/{{domesticPaymentId}}

{
    "Data": {
        "DomesticPaymentId": "eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "ConsentId": "eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "CreationDateTime": "2020-02-10T07:46:27.251Z",
        "Status": "Rejected",
        "StatusUpdateDateTime": "2020-02-10T07:46:27.26Z",
        "ExpectedExecutionDateTime": null,
        "ExpectedSettlementDateTime": null,
        "Charges": null,
        "Initiation": {
            "InstructionIdentification": "instr-identification",
            "EndToEndIdentification": "e2e-identification",
            "LocalInstrument": null,
            "InstructedAmount": {
                "Amount": "50.00",
                "Currency": "GBP"
            },
            "DebtorAccount": null,
            "CreditorAccount": {
                "SchemeName": "IBAN",
                "Identification": "BE56456394728288",
                "Name": "ACME DIY",
                "SecondaryIdentification": "secondary-identif"
            },
            "CreditorPostalAddress": null,
            "RemittanceInformation": {
                "Unstructured": "Tools",
                "Reference": "Tools"
            },
            "SupplementaryData": null
        },
        "MultiAuthorisation": null
    },
    "Links": {
        "Self": "https://ob.rbs.useinfinite.io/open-banking/v3.1/pisp/domestic-payments/eaaef011-58c0-40e2-8a69-3bc33e6199ec",
        "First": null,
        "Prev": null,
        "Next": null,
        "Last": null
    },
    "Meta": {
        "TotalPages": 1,
        "FirstAvailableDateTime": null,
        "LastAvailableDateTime": null
    }
} 


#### How to run SDK with MATLS

#### Scripts

Script folder contains helper scripts for working with certificates.

#### Generating JKS files from P12 certificates

Use script 
| Position | Name                      | Description                                                                                |
|----------|---------------------------|--------------------------------------------------------------------------------------------|
| 1        | ENVIRONMENT               | This specifies which environment you are generating the JKS for and controls which signing chain is added to the transport certificate |
| 2        | CERTIFICATE_TYPE          | Is this a ```transport``` or ```signing``` certificate                                     |
| 3        | SOFTWARE_ID               | The software id of this certificate from the OB Directory (must match the CN of the certificate) |
| 4        | INPUT_CERT_P12            | The file name of the input .p12 or .pfx - can be a file path too (e.g. /path/to/cert.p12)  |
| 5        | INPUT_CERT_P12_PASSPHRASE | The passphrase protecting the input .p12 or .pfx                                           |
| 6        | INPUT_CERT_KEY_ID         | The Key ID from the OB Directory for this particular certificate                           |
| 7        | OUTPUT_JKS_NAME           | The file name of the JKS to create - can be a file path too (e.g. /path/to/store.jks)      |
| 8        | OUTPUT_JKS_PASSPHRASE     | The pass phrase to protect the JKS                                                         |

#### Example usage


./generate_keystore_ob_prod.sh prod transport <SOFTWARE_ID> ../path/to/developer.natwest.com_transport.p12 <redacted> _BV7npW7Q38wzTRgMEeKYHK7Ny0 transport.jks <redacted>
```
Once you have generated the JKS file, you can set the keystore/truststore location and password in application.yml file and set the property enableMatls to true.

>**Note: For further documentation and request bodies please visit Bank of APIs [Payments](https://www.bankofapis.com/products/payments/) and [Accounts](https://www.bankofapis.com/products/accounts/)**