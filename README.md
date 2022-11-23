# health-mgmt-system
Health Management System

step 1: please create database name as hms mysql.
step 2: clone the project 
step 3: import the project in your favourite IDE(STS)
step 4: right click on project ruan as spring boot application
Step 5: below are API collection for the same:
{
	"info": {
		"_postman_id": "80e9497d-cf0c-4c2b-b42c-654b279c07bb",
		"name": "health-mgmt-system API",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "create doctor",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\":\"Kelwin Obrien\",\r\n    \"email\":\"klwin@foxst.com\",\r\n    \"degree\": \"MBBS(Ser)\",\r\n    \"specialization\":\"Sergeon specialist\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors"
					]
				}
			},
			"response": []
		},
		{
			"name": "update doctor",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\": \"Berlwin suang up\",\r\n    \"email\": \"blinsung@mttpup.com\",\r\n    \"degree\": \"MBBS(Harmonlogy)\",\r\n    \"specialization\": \"Harmonlogy spl\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/8",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"8"
					]
				}
			},
			"response": []
		},
		{
			"name": "get doctors list",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors"
					]
				}
			},
			"response": []
		},
		{
			"name": "delete doctor",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/8",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"8"
					]
				},
				"description": "Create Post"
			},
			"response": []
		},
		{
			"name": "create patients",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\":\"Test Kale\",\r\n    \"email\":\"testkal@gmail.com\",\r\n    \"contactNo\":\"+918869899862\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/8/patients",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"8",
						"patients"
					]
				}
			},
			"response": []
		},
		{
			"name": "update patients",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\":\"Test Kale update\",\r\n    \"email\":\"testkalup@gmail.com\",\r\n    \"contactNo\":\"+918869899862\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/10/patients/6",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"10",
						"patients",
						"6"
					]
				}
			},
			"response": []
		},
		{
			"name": "get patients list",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\":\"Pritam Pyare Update\",\r\n    \"email\":\"prtamup@gmail.com\",\r\n    \"contactNo\":\"+918969899890\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/2/patients/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"2",
						"patients",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "delete patient",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\":\"Turam Prasad Update\",\r\n    \"email\":\"turamp@yahoo.com\",\r\n    \"degree\": \"MBBS/PHD/MPHIL\",\r\n    \"specialization\":\"Backbone and Muscle specialist\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/doctors/8/patients/15",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"doctors",
						"8",
						"patients",
						"15"
					]
				}
			},
			"response": []
		}
	]
}