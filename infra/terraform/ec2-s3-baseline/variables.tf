variable "aws_region" {
  description = "AWS region for the resources."
  type        = string
}

variable "project_name" {
  description = "Short name used for tagging and naming."
  type        = string
  default     = "springboot-aws-learning"
}

variable "vpc_id" {
  description = "VPC ID where the EC2 instance and security group will be created."
  type        = string
}

variable "subnet_id" {
  description = "Subnet ID for the EC2 instance."
  type        = string
}

variable "key_pair_name" {
  description = "Existing AWS key pair name for SSH access."
  type        = string
}

variable "instance_type" {
  description = "EC2 instance type."
  type        = string
  default     = "t3.micro"
}

variable "allowed_ssh_cidr" {
  description = "CIDR block allowed to connect over SSH."
  type        = string
}

variable "bucket_name" {
  description = "Globally unique S3 bucket name."
  type        = string
}

