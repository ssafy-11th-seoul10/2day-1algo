#!/bin/bash

# Git pull 명령 실행
git pull

# Git add 명령을 실행하여 파일을 추가합니다. 예: git add file1.txt file2.txt
git add .

# git status 명령을 실행하여 추가된 파일 목록을 가져옵니다.
file=$(git diff --cached --name-only)

if [ -z "$file" ]; then
  echo "No files to commit."
  exit 1
fi

file_name=$(echo $file | rev | cut -d ':' -f 1 | rev)

# Git Config name도 사용 가능
name="박상욱"

git commit -m "$name\_$file_name"
  
done

# 변경 사항을 원격 저장소로 푸시합니다.
git push