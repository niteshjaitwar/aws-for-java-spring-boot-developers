package com.example.aws.lambda;

import java.time.Instant;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

public class HelloLambdaHandler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

	@Override
	public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
		String path = event == null || event.getRawPath() == null ? "/" : event.getRawPath();
		String body = """
			{
			  "message": "Hello from AWS Lambda",
			  "path": "%s",
			  "requestId": "%s",
			  "timestamp": "%s"
			}
			""".formatted(path, context.getAwsRequestId(), Instant.now());

		return APIGatewayV2HTTPResponse.builder()
			.withStatusCode(200)
			.withHeaders(Map.of("Content-Type", "application/json"))
			.withBody(body)
			.build();
	}
}

