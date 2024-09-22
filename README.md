# Project of a AWS Lambda with API Gateway, and DynamoDB

This project sets up an Java 21 AWS Lambda function using Spring Boot 3, which is triggered by an API Gateway and interacts with a DynamoDB table to manage user data. The DynamoDB table stores user data with fields `uuid`, `email`, and `created_at`.

## Requirements

- Java 21
- Maven
- AWS CLI (configured)
- Terraform

## Setup Instructions

1. **Clone the repository**:
    ```
    git clone https://github.com/ccallazans/aws-lambda-spring-boot.git
    cd aws-lambda-spring-boot
    ```

2. **Build the Spring Boot project**:
    ```
    ./mvnw clean package
    ```

3. **Deploy the infrastructure using Terraform**:
    - Go to /terraform folder
      ```
      cd terraform
      ```
    - Initialize Terraform:
        ```
        terraform init
        ```
    - Apply the Terraform configuration:
        ```
        terraform apply
        ```
## Usage

The API Gateway exposes two endpoints to interact with the user data:

1. **GET /users**: Retrieve all users
    ```
    curl -X GET https://your-api-id.execute-api.us-east-1.amazonaws.com/your-stage/users
    ```

2. **POST /users**: Create a new user
    ```
    curl -X POST https://your-api-id.execute-api.us-east-1.amazonaws.com/your-stage/users \
    -H "Content-Type: application/json" \
    -d '{"email": "user@example.com"}'
    ```

## MIT License