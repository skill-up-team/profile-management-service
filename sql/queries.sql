INSERT INTO public.specializations(name)
VALUES ('Physician'), ('ENT Surgeon'), ('Gynaecologist'), ('Psychologist'), ('Cardiologist'), ('Eye Surgeon');

INSERT INTO public.doctors(
    first_name, last_name, specialization_id)
VALUES ('Achintha', 'Silva', 3), ('Achini', 'Gamage', 4), ('Ajantha', 'Dias', 5),
       ('Lasantha', 'Peries', 1), ('Mihiri', 'Maduka', 2), ('Pradeepa', 'Perera', 6);

INSERT INTO public.hospitals(address, name)
VALUES ('Colombo 05', 'Asiri Surgical Hospital'), ('Ratnapura', 'Aloka Private Hospital'),
       ('Mount Lavinia', 'Mount Lotus Eye & ENT Hospital'), ('Colombo 02', 'Nawaloka Hospital');

INSERT INTO public.patients(
    address, date_of_birth, first_name, last_name, nic_no)
VALUES ('Colombo 03', '1994-02-07', 'John', 'Perera', '1234'),
       ('Galle', '1958-08-06', 'Ann', 'de Silva', '34567'),
       ('Ratnapura', '1974-05-12', 'Steve', 'Dias', '78907');

INSERT INTO public.laboratories(
    address, name, reg_num)
VALUES ('Colombo 04', 'Durdans', 'Test1'),
       ('Piliyandala', 'Asiri', 'Test2'),
       ('Kotte', 'Nawaloka Lab', 'Test3');

INSERT INTO public.services(
    name, service_fee)
VALUES ('Thyroid Profile (TSH / fT4)', 1500.0), ('Urine Full Report (UFR)', 950.0),
       ('TPHA', 1000.0), ('Rheumatoid Factor', 1200.0), ('Lipid Profile (Cholesterol / HDL / LDL / VLDL)', 1500.0);