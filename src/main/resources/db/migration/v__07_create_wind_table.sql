CREATE TABLE public.wind (
    id NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    speed NUMBER ,
    deg NUMBER,
    weather_response_id NUMBER
);
