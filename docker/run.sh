#!/usr/bin/env bash

set -eux

MAIN_CLASS="vn.kamereo.hiring.$1"

java \
  -Dspring.profiles.active="${ACTIVE_PROFILES}" \
  -Dsentry.environment="${APP_ENV}" \
  -classpath "/app/application.jar" \
  -Dloader.main="$MAIN_CLASS" \
  org.springframework.boot.loader.PropertiesLauncher "$@"
