ALTER TABLE notetype
    ALTER COLUMN discussiontopics TYPE TEXT USING (discussiontopics::TEXT)