# Appointment API

Spring Boot ile geliştirilmiş basit bir Randevu Yönetim API’si.

Bu proje; controller, service, repository katmanları ayrılmış şekilde,
DTO kullanımı ve merkezi exception handling yaklaşımıyla hazırlanmıştır.

## Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL
- Maven

## Endpointler

### 1. Randevu Oluşturma

POST /appointments

Request Body:
```json
{
  "customerName": "Ömer",
  "description": "İlk randevu"
}
Randevu İptal Etme
Tüm Randevuları Listeleme
Tek Randevu Getirme
Hata Yönetimi

Randevu bulunamadığında veya iş kuralı ihlallerinde
BusinessException fırlatılır ve GlobalExceptionHandler tarafından yakalanır.
