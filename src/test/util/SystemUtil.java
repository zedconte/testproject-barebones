/*
 * testproject-challenge
 * Copyright (C) 2020  Raul Ortega
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SystemUtil {

    static public Properties resource = null;

    /**
     * load the test data in properties file
     * @param fileName : The file name to load
     *
     *
     */
    static public Properties loadPropertiesResources(String fileName) {
        resource = new Properties();
        try {
            File file=new File("./testdata/"+fileName);
            InputStream data_input = new FileInputStream(file);
            resource.load(data_input);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error:Not found properties file"+ fileName);
            e.printStackTrace();
        }

        return resource;
    }
}
