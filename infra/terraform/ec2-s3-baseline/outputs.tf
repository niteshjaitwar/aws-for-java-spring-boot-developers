output "ec2_public_ip" {
  description = "Public IP of the EC2 instance."
  value       = aws_instance.app_server.public_ip
}

output "s3_bucket_name" {
  description = "Name of the S3 bucket."
  value       = aws_s3_bucket.app_bucket.bucket
}

output "security_group_id" {
  description = "Security group ID attached to the EC2 instance."
  value       = aws_security_group.app_sg.id
}

