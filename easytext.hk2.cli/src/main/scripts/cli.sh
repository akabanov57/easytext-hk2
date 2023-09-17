#!/bin/bash
help()
{
  echo "Usage: cli -f <textfile>"
  echo "   or  cli -h" 
}
TEMP=$(getopt -o 'f:h' -n 'cli.sh' -- "$@")

if [ $? -ne 0 ]; then
  exit 1
fi

eval set -- "$TEMP"
unset TEMP
APP_ARG=""
while true; do
  case "$1" in
    '-f')
      APP_ARG=${2}
      shift 2
      break
    ;;
    '-h'|'--')
      help
      exit
    ;;
    '*')
      echo 'Internal error!' >&2
      exit 1
    ;;
  esac
done

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
--module easytext.cli/javamodularity.easytext.cli.Main ${APP_ARG}
