#!/bin/bash

server_ids=(5 6 7)
function get_server_id() {
  local index=$(($1 % ${#server_ids[@]}))
  echo "${server_ids[$index]}"
}

function generate_dael_agg_report() {
  #  echo "request to server #$1 account is $2"
  sleep $((RANDOM % 10))
}

declare -a account_ids
for i in {0..102}; do
  account_ids+=($((RANDOM % 10000)))
done

batch_size=$((10))
for ((i = 0, count = batch_size; i < ${#account_ids[@]}; i++)); do
  server_id=$(get_server_id "$i")
  account="${account_ids[$i]}"
  if [[ "$count" -gt 0 ]]; then
    ((count--))
    echo "request to server #$server_id account is $account"
    generate_dael_agg_report "$server_id" "$account" &
  else
    echo "waiting a bit..."
    wait
    count=$batch_size
  fi
done

echo "waiting for finish..."
wait
echo "Finished!"
