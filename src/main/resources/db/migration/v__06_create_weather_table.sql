CREATE TABLE public.weather (
    weather_id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id NUMBER,
    main VARCHAR(255),
    description VARCHAR(255),
    icon VARCHAR(255),
    weather_response_id NUMBER
);
