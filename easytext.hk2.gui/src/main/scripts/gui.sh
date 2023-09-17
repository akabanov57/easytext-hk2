#!/bin/bash
SCRIPT_PATH="${BASH_SOURCE}"
while [ -L "${SCRIPT_PATH}" ]; do
  SCRIPT_DIR="$(cd -P "$(dirname "${SCRIPT_PATH}")" >/dev/null 2>&1 && pwd)"
  SCRIPT_PATH="$(readlink "${SCRIPT_PATH}")"
  [[ ${SCRIPT_PATH} != /* ]] && SCRIPT_PATH="${SCRIPT_DIR}/${SCRIPT_PATH}"
done
SCRIPT_PATH="$(readlink -f "${SCRIPT_PATH}")"

# assume this script is in APP_HOME/bin directory
APP_HOME="$(cd -P "$(dirname -- "${SCRIPT_PATH}")/.." >/dev/null 2>&1 && pwd)"
${JAVA_HOME}/bin/java -Dfile.encoding=UTF-8 --module-path ${APP_HOME}/lib \
--add-modules ALL-MODULE-PATH \
--module easytext.gui/javamodularity.easytext.gui.Main
