#!/bin/bash
set -eux

dnf update -y
dnf install -y java-21-amazon-corretto-devel nginx git
systemctl enable nginx
systemctl start nginx

