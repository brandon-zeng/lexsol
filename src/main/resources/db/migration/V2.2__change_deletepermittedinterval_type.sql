ALTER TABLE notetype
    ALTER COLUMN deletepermittedinterval TYPE INTEGER USING (deletepermittedinterval::INTEGER)