#!/bin/sh

curl -H "Test-Header: test-header-value" -b "Test-Cookie=test-cookie-value" 'localhost:9532/echo?test_param=test-param-value'
echo ""
