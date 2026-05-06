FROM golang:1.26.2-alpine3.23 as builder
WORKDIR /app
COPY ./main.go ./
RUN go build -o /go-app ./main.go

FROM alpine:3.22.4
EXPOSE 8080
COPY --from=builder /go-app .
ENTRYPOINT [ "./go-app" ]