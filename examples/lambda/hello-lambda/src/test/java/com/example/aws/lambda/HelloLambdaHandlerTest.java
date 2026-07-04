package com.example.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

class HelloLambdaHandlerTest {

	@Test
	void returnsSuccessfulJsonResponse() {
		HelloLambdaHandler handler = new HelloLambdaHandler();
		APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent();
		event.setRawPath("/hello");

		APIGatewayV2HTTPResponse response = handler.handleRequest(event, new TestContext());

		assertEquals(200, response.getStatusCode());
		assertTrue(response.getBody().contains("Hello from AWS Lambda"));
		assertTrue(response.getBody().contains("/hello"));
	}

	private static final class TestContext implements Context {

		@Override
		public String getAwsRequestId() {
			return "test-request-id";
		}

		@Override
		public String getLogGroupName() {
			return "test-log-group";
		}

		@Override
		public String getLogStreamName() {
			return "test-log-stream";
		}

		@Override
		public String getFunctionName() {
			return "hello-lambda";
		}

		@Override
		public String getFunctionVersion() {
			return "1";
		}

		@Override
		public String getInvokedFunctionArn() {
			return "arn:aws:lambda:us-east-1:123456789012:function:hello-lambda";
		}

		@Override
		public CognitoIdentity getIdentity() {
			return null;
		}

		@Override
		public ClientContext getClientContext() {
			return null;
		}

		@Override
		public int getRemainingTimeInMillis() {
			return 30_000;
		}

		@Override
		public int getMemoryLimitInMB() {
			return 512;
		}

		@Override
		public LambdaLogger getLogger() {
			return new LambdaLogger() {
				@Override
				public void log(String message) {
				}

				@Override
				public void log(byte[] message) {
				}
			};
		}
	}
}
