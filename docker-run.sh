docker run -d \
  --name my-postgres \
  -p 5432:5432 \
  -e POSTGRES_DB=e-commerce \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  postgres:latest
