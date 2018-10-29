1. start docker daemon in separate terminal > ''sudo dockerd''

2. Run docker compose with specific file: docker-compose -f filename up

3. Rebuild containers: docker-compose -f docker-compose2.yml up --build

4. Force recreate / don't use cache: docker-compose -f docker-compose1.yml up --build --force-recreate

